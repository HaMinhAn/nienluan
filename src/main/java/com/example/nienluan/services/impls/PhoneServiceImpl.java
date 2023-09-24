package com.example.nienluan.services.impls;

import com.example.nienluan.dto.CreatePicture;
import com.example.nienluan.dto.PhoneRequest;
import com.example.nienluan.dto.PhoneResponse;
import com.example.nienluan.exceptions.AppException;
import com.example.nienluan.mappers.PhoneMapper;
import com.example.nienluan.mappers.PictureMapper;
import com.example.nienluan.models.Category;
import com.example.nienluan.models.Manufacturer;
import com.example.nienluan.models.Phone;
import com.example.nienluan.models.Picture;
import com.example.nienluan.repository.CategoryRepository;
import com.example.nienluan.repository.ManufacturerRepository;
import com.example.nienluan.repository.PhoneRepository;
import com.example.nienluan.repository.PictureRepository;
import com.example.nienluan.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

  @Autowired
  private PhoneRepository phoneRepository;
  @Autowired
  private PhoneMapper phoneMapper;

  @Autowired
  private ManufacturerRepository manufacturerRepository;

  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private PictureRepository pictureRepository;
  @Autowired
  private PictureMapper pictureMapper;

  @Override
  public Page<Phone> getPhones(int page, int size) {
    PageRequest pageRequest = PageRequest.of(page, size);
    Page<Phone> phoneList = phoneRepository.findAll(pageRequest);
//    phoneList.get().map((Phone::getId) -> {})
//    Manufacturer manufacturer = manufacturerRepository.findById();
    return phoneList;
  }

  @Override
  public PhoneResponse addPhone(PhoneRequest phoneRequest) {
    Optional<Phone> phoneOptional = phoneRepository.findByName(phoneRequest.getName());
    if (phoneOptional.isPresent()) {
      throw new AppException("Dien thoai da ton tai", HttpStatus.BAD_GATEWAY);
    }
    Phone phone = phoneMapper.toPhone(phoneRequest);
    Optional<Manufacturer> manufacturer = manufacturerRepository.findById(phoneRequest.getManufacturer());
    if (manufacturer.isEmpty()) {
      throw new AppException("Khong tim thay nha san xuat", HttpStatus.NOT_FOUND);
    }
    phone.setManufacturer(manufacturer.get());
    Optional<Category> category = categoryRepository.findById(phoneRequest.getCategory());
    if (category.isEmpty()) {
      throw new AppException("Khong tim thay phan loai", HttpStatus.NOT_FOUND);
    }

    phone.setCategory(category.get());
    Phone phone1 = phoneRepository.save(phone);
    List<Picture> pictureList = new ArrayList<>();
    for (CreatePicture pic: phoneRequest.getPicture()
    ) {
      if(pictureRepository.findByCaption(pic.getCaption()).isEmpty()){
        pictureRepository.save(pictureMapper.toPicture(pic, phone1));
      }
    }
    return phoneMapper.toPhoneResponse(phone1.getId(), phoneRequest.getName());
  }

  @Override
  public Page<Phone> getListPhoneByManufacturer(Integer id, int page, int size) {
    PageRequest pageRequest = PageRequest.of(page, size);
    Optional<Manufacturer> manufacturer = manufacturerRepository.findById(id);
    Page<Phone> phones = phoneRepository.findAllByManufacturer(manufacturer.get(), pageRequest);
    if(phones.isEmpty()){
      throw new AppException("Hien tai khong co dien thoai nao thuoc hang nay",HttpStatus.NOT_FOUND);
    }



    return phones;
  }
}
