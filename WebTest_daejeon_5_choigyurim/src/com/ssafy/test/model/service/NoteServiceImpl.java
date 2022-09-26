package com.ssafy.test.model.service;

import java.util.List;

import com.ssafy.test.dto.NoteDto;
import com.ssafy.test.model.dao.NoteDAO;
import com.ssafy.test.model.dao.NoteDAOImpl;

public class NoteServiceImpl implements NoteService{
	private static NoteServiceImpl noteServiceImpl = new NoteServiceImpl();

	public static NoteServiceImpl getService() {
		return noteServiceImpl;
	}

	private NoteDAOImpl noteDao;

	public NoteServiceImpl() {
		noteDao = NoteDAOImpl.getDao();
	}

	@Override
	public boolean insert(NoteDto noteDto) {
		return noteDao.insert(noteDto);
	}

	@Override
	public List<NoteDto> getNotes() {
		return noteDao.selectAll();
	}

	@Override
	public NoteDto getNote(String noteCode) {
		return noteDao.selectOne(noteCode);
	}

	@Override
	public void remove(String noteCode) {
		noteDao.delete(noteCode);
	}

}
