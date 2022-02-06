package com.eva.project.service.impl;

import com.eva.project.dto.UserDto;
import com.eva.project.entity.Adres;
import com.eva.project.entity.User;
import com.eva.project.repo.AdresRepository;
import com.eva.project.repo.UserRepository;
import com.eva.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AdresRepository adresRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        //Assert.notNull(kisiDto.getAdi(), "Adi alani zorunludur!");

        User user = new User();
        user.setName(userDto.getAdi());
        user.setSurname(userDto.getSoyadi());
        final User userDb = userRepository.save(user);

        List<Adres> liste = new ArrayList<>();
//        userDto.getAdresler().forEach(item -> {
//            Adres adres = new Adres();
//            adres.setAdres(item);
//            adres.setAdresTip(Adres.AdresTip.DIGER);
//            adres.setAktif(true);
//            adres.setUser(userDb);
//            liste.add(adres);
//        });
//        adresRepository.saveAll(liste);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(it -> {
            UserDto userDto =new UserDto();
            userDto.setId(it.getId());
            userDto.setAdi(it.getName());
            userDto.setSoyadi(it.getSurname());
            userDto.setPortfolios(it.getPortfolios());
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
