package baitapnha.jpa.hoangduy.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import baitapnha.jpa.hoangduy.blog.entity.TagName;
import baitapnha.jpa.hoangduy.blog.repository.TagNameRepository;
import baitapnha.jpa.hoangduy.blog.service.define.BaseService;
import baitapnha.jpa.hoangduy.blog.service.define.PageService;

@Service
public class TagnameServiceImpl implements BaseService<TagName> {

	@Autowired
	private TagNameRepository tagnameRepository;

	@Override
	public List<TagName> getAll() {
		// TODO Auto-generated method stub
		return tagnameRepository.findAll();
	}

	@Override
	public void save(TagName object) {
		tagnameRepository.save(object);
		
	}

	@Override
	public TagName getByID(int id) {
		// TODO Auto-generated method stub
		return tagnameRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		tagnameRepository.deleteById(id);
		
	}
	
	

}
