package com.ssafy.test.model.dao;

import java.util.List;

import com.ssafy.test.dto.NoteDto;

public interface NoteDAO {
	// 노트북 정보 등록
	public boolean insert(NoteDto noteDto);

	// 노트북 목록 조회
	public List<NoteDto> selectAll();

	// 노트북 정보 상세 조회
	public NoteDto selectOne(String codeNote);

	// 노트북 정보 삭제
	public void delete(String codeNote);
}
