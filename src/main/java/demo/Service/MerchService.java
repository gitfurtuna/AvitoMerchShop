package demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.Repository.MerchRepository;

@Service
public class MerchService {

    @Autowired
    private MerchRepository merchRepository;
}
