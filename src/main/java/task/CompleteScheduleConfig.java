package task;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
*
* @version 2019年2月27日 上午9:22:12
*
* @author zhr
*/
public class CompleteScheduleConfig implements SchedulingConfigurer{
    private  ScheduledTaskRegistrar taskRegistrar;
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		this.taskRegistrar = taskRegistrar;
		//CronTask cronTask = new CronTask(() -> System.out.println("定时任务"),new CronTrigger("*/5 * * * * ?"));
		taskRegistrar.addTriggerTask(() -> System.out.println("定时任务"), new CronTrigger("*/5 * * * * ?"));
	}
    public static void main(String[] args) {
    	System.out.println("定时任务启动");
    	// 失败
	}
}
