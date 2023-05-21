package com.ssafy.pjt.api.diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.DiaryDao;
import com.ssafy.pjt.model.dto.Diary;

@Service
public class DiaryServiceImpl implements DiaryService{

	private DiaryDao diaryDao;

	@Autowired
	public void setDiaryDao(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}
	
	@Override
	public List<Diary> getDiaryList() {
		return diaryDao.selectAll();
	}

	@Override
	public Diary readDiaryById(int id) {
		return diaryDao.selectOneById(id);
	}

	@Override
	public Diary readDiaryByDate(String date) {
		return diaryDao.selectOneByDate(date);
	}

	@Override
	public boolean writeDiary(Diary diary) {
		return diaryDao.insertDiary(diary) > 0;
	}

	@Override
	public boolean removeDiary(int id) {
		return diaryDao.deleteDiary(id) > 0;
	}

	@Override
	public boolean modifyDiary(int id) {
		return diaryDao.updateDiary(id) > 0;
	}

}