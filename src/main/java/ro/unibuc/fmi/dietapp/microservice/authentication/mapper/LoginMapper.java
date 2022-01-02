package ro.unibuc.fmi.dietapp.microservice.authentication.mapper;

import org.mapstruct.Mapper;
import ro.unibuc.fmi.dietapp.microservice.authentication.dto.LoginDto;
import ro.unibuc.fmi.dietapp.microservice.authentication.model.Login;

@Mapper
public interface LoginMapper extends EntityMapper<LoginDto, Login> {
}
