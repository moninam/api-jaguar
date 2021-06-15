package com.uady.apijaguar.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.uady.apijaguar.model.Target;
import com.uady.apijaguar.repository.TargetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Service
@Transactional
public class TargetService {
    @Autowired
    TargetRepository targetRepository;

    private Logger logger = LogManager.getLogger(this.getClass());

    public Optional<Target> findById(Integer id){
        return targetRepository.findById(id);
    }
}
