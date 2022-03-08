package edu.byu.is560r.bsierra1notesapinew.Config;

import edu.byu.is560r.bsierra1notesapinew.service.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfiguration {

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }

}
