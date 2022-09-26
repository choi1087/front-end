package com.ssafy.test.model.service;

import java.util.List;

import com.ssafy.test.dto.NoteDto;

public interface NoteService {
	// 노트북 정보 등록
	public boolean insert(NoteDto noteDto);

	// 노트북 목록 조회
	public List<NoteDto> getNotes();

	// 노트북 정보 상세 조회
	public NoteDto getNote(String noteCode);

	// 노트북 정보 삭제
	public void remove(String noteCode);
}
