package uz.ruslan.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;

/**
 * date 9/29/16.
 */
@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConfiguration implements SchedulingConfigurer {

    @Bean(name = "threadPoolTaskExecutor", destroyMethod = "shutdown")
    public Executor threadPoolTaskExecutor() {
        final ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();

        executor.setDaemon(false);
        executor.setPoolSize(10);
        return executor;
    }

    @Bean(name = "SimpleAsyncTaskExecutor")
    public TaskExecutor simpleTaskExecutor() {
        final SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(10);
        taskExecutor.setDaemon(false);

        return taskExecutor;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(this.threadPoolTaskExecutor());
    }
}
