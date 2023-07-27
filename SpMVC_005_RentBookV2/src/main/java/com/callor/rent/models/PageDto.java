package com.callor.rent.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageDto {

	private int pageNum = 1; // 보고자 하는 페이지 번호
	
	private int totalCount; 	// 데이터의 전체 개수
	private int offsetNum = 0;  // 시작페이지 번호(기본값은 0 부터) 
	private int limitCount = 10; // 보여질 데이터 개수(기본값은 10개)
	
	private int pageNumCount; // 하단 pagination 에 보여질 번호개수
	
	private int firstPageNum;  // 전체데이터의 첫번째 페이지 번호
	
	/*
	 * totalCount 가 153 이라고 하자
	 * 한 페이지에 10개의 데이터를 보여준다고 할때
	 * 계산한 페이지 개수는 ?
	 * 
	 * int(totalCount / 10) + 1 => 15 : 1 ~ 15페이까지 페이지 번화
	 * 	1 페이지 : 0 ~ 9
	 * 	15 페이지 : (page - 1) * 10 : 14 * 10 : 140 ~ 149
	 * 	16 페이지 :	15 * 10 : 150 ~ 153
	 * 이 예제에서 finalPageNum = 16 값이 된다.
	 * 
	 * 150개 / 10 : 15
	 * 	1 : 0 ~ 9 
	 * 	15 : 140 ~ 149
	 *  16 : 150 ~
	 * 
	 */
	private int finalPageNum;  // 전체데이터의 마지막 페이지 계산 결과
	public int getFinalPageNum() {
		if(totalCount < 1) return 0;
		
		// this.finalPageNum = (int)(this.totalCount / limitCount) + 1;
		// (150 + (10 - 1)) / 10 = 15
		this.finalPageNum = (this.totalCount + (this.limitCount - 1))  /  this.limitCount;
		return this.finalPageNum;
	}
	
	public int getOffSetNum() {
		this.offsetNum = (pageNum - 1) + limitCount;
		return this.offsetNum;
	}
	
	
	
}


