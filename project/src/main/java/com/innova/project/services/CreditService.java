package com.innova.project.services;

import com.innova.project.model.User;
import com.innova.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditService {
    @Autowired
    UserRepository userRepository;

    public String credit(Long tckn) {
        User user = userRepository.getByTckn(tckn);
        if (user.getCreditNote() >= 1000) {
            int value = user.getSalary() * 4;
            user.setStatus("Accepted : " + value);
            userRepository.save(user);
            return "Accepted : " + value;
        } else if ((user.getCreditNote() > 500 && user.getCreditNote() < 1000) && (user.getSalary() > 5000)) {
            user.setStatus("Accepted : 20000");
            userRepository.save(user);
            return "Accepted : 20000";
        } else if ((user.getCreditNote() > 500 && user.getCreditNote() < 1000) && (user.getSalary()) <= 5000) {
            user.setStatus("Accepted : 10000");
            userRepository.save(user);
            return "Accepted : 10000";
        } else {
            user.setStatus("Rejected");
            userRepository.save(user);
            return "Rejected";
        }
    }
}
