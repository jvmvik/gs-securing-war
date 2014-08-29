package sample.ui.secure;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class SampleWebXml extends SpringBootServletInitializer 
{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
    {
        return application.sources(SampleWebSecureApplication.class);
    }

}