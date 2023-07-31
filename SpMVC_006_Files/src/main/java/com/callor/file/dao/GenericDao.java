package com.callor.file.dao;

import java.util.List;

/*
 * 제네릭 타입 인터페이스
 * 
 * 이 인터페이스는 다른 Dao 를 만들때 부모 인터페이스 역할을 수행한다
 * <DTO, PK> : 제네릭 타입의 변수 선언
 * 이 인터페이스를 상속받을때, 자신이 사용할 DTO 클래스와 PK 변수를
 * 제네릭에 설정해 주면
 */
public interface GenericDao<DTO, PK> {

	public List<DTO> selectAll();
	public DTO findById(PK id);
	
	public int insert(DTO dto);
	public int update(DTO dto);

	public int delete(PK id);
	
}


