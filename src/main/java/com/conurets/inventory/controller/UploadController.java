package com.conurets.inventory.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.BasicInformation;
import com.conurets.inventory.model.BasicInfoxl;
import com.conurets.inventory.service.UploadService;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.util.xlutil.Utilityxl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class UploadController extends BaseController {
	
	private final UploadService uploadService;

	public UploadController(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@GetMapping("/upload")
	public List<Map<String, String>> upload(@RequestParam("file") MultipartFile file) throws InventoryException, Exception{

		String fileName=file.getOriginalFilename();
		String fileur= InventoryUtil.PROJECT_FILES +fileName;
		Utilityxl obj=new Utilityxl();
		List<BasicInfoxl> lst=obj.test(fileur);
		lst.forEach(s -> {
			BasicInformation basicInformation=new BasicInformation();

			//Date date=simpleDateFormat.parse(s.getDate_Item_Entered());
			Date date=new Date();
			basicInformation.setEntryDate(date);
			//basicInformation.se(s.getManufacturer());
			basicInformation.setLocationId(1);
			basicInformation.setUserId(1);
			basicInformation.setCompanyId(1);
			basicInformation.setItemId(1);
			basicInformation.setQty(Integer.valueOf(s.getQty()));
			basicInformation.setSerialNo(String.valueOf(System.currentTimeMillis()));
			//basicInformation.setSerialNumber(s.getSerial_Number());
			//basicInformation.setItemId(Integer.valueOf(s.getItem_Id()));
			basicInfoService.save(basicInformation);

		});


		return null; //uploadService.upload(file);
	}
}
