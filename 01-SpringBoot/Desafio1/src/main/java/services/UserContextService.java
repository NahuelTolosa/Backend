package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserContextRepository;

@Service
public class UserContextService {

    @Autowired
    UserContextRepository userContextRepository;

}
