package br.com.fiap.mscatalogoprodutos.config;

import br.com.fiap.mscatalogoprodutos.entity.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig  {

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor();
        executor.setConcurrencyLimit(10); // Set the number of concurrent threads (adjust as needed)
        return executor;
    }

    @Bean(name = "importProductJob")
    public Job importProductJob(JobRepository jobRepository, Step step) {
        return  new JobBuilder("importProductJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }


    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager, ItemReader<Product> reader, ItemWriter<Product> writer, TaskExecutor taskExecutor,
    ItemProcessor<Product, Product> processor) {
        return new StepBuilder("step", jobRepository)
                .<Product, Product>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                //.taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public ItemReader<Product> reader() {
        BeanWrapperFieldSetMapper<Product> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Product.class);
        return new FlatFileItemReaderBuilder<Product>()
                .name("productItemReader")
                .resource(new ClassPathResource("products.csv"))
                .delimited()
                .names("name", "description", "price")
                .fieldSetMapper(fieldSetMapper)
                .build();
    }

    /*public ItemWriter<Product> writer() {
        //gravar no banco de dados os produtos lidos do arquivo csv e processados pelo processor (ItemProcessor)
        JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO product (name, description, price) VALUES (:name, :description, :price)");
        writer.setDataSource(this.dataSource);
        return writer;
    }*/

    @Bean
    public ItemWriter<Product> writer(DataSource dataSource) {
        return  new JdbcBatchItemWriterBuilder<Product>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO product (name, description, price) VALUES (:name, :description, :price)")
                .dataSource(dataSource)
                .build();
    }



    @Bean
    public ItemProcessor<Product, Product> processor() {
        return new ProductProcessor();
    }


}
