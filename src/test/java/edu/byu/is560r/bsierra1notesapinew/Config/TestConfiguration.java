package edu.byu.is560r.bsierra1notesapinew.Config;

import edu.byu.is560r.bsierra1notesapinew.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.mockito.Mockito;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {

    @Bean(name="userService")
    public UserService getUserService() {
        return Mockito.mock(UserService.class);
    }
}
