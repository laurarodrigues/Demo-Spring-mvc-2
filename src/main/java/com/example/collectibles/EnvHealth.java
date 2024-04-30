package com.example.collectibles;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class EnvHealth implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        String customEnv = System.getenv("MY_CUSTOM_ENV");
        if(customEnv != null){
            return HealthCheckResponse.named("EnvCheck")
                    .withData("present", true)
                    .up()
                    .build();
        }else{
            return HealthCheckResponse.named("EnvCheck")
                    .withData("presetn", false)
                    .down()
                    .build();
        }
    
    }
    
}
