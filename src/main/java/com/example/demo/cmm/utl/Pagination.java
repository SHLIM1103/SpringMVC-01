package com.example.demo.cmm.utl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.demo.cmm.service.CommonMapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component("page") @Data @Lazy
@NoArgsConstructor
public class Pagination {
	@Autowired CommonMapper mapper; 
	
	private int totalCount, startRow, endRow,
				pageCount, pageSize, startPage, endPage, pageNum,
				blockCount, prevBlock, nextBlock, blockNum;

	public final int BLOCK_SIZE = 5 ; // 한 블럭당 페이지 갯수
	private String tname;
	private boolean existPrev, existNext ;
	
	public Pagination(String tname, int pageSize, int pageNum, int count) {
		this.tname = tname; // 테이블 이름
		this.pageSize = pageSize; // 한 페이지 당 게시글 수
		this.pageNum = pageNum; // 현재 페이지 번호
		this.totalCount = count; // 총 게시글 수
		this.pageCount = (totalCount % pageSize != 0) ? totalCount/pageSize + 1: totalCount/pageSize; // 페이지 총 갯수
		this.blockCount = (pageCount % BLOCK_SIZE != 0) ? pageCount / BLOCK_SIZE + 1 : pageCount / BLOCK_SIZE; // 블럭 총 갯수
		this.startRow = (pageNum - 1) * pageSize; // 페이지의 첫 게시글 번호
		this.endRow = (pageCount != pageNum) ? startRow + pageSize - 1 : totalCount - 1; // 각 페이지의 마지막 게시글 번호
		this.blockNum = (pageNum - 1) / BLOCK_SIZE; // 현재 블럭 번호
		this.startPage = blockNum * BLOCK_SIZE + 1; // 각 블럭의 첫 페이지 번호
		this.endPage = ((blockNum + 1) != blockCount) ? startPage + (BLOCK_SIZE - 1) : pageCount; // 각 블럭의 마지막 페이지 번호
		this.existPrev = blockNum != 0; // 이전 블럭이 있는지?
		this.existNext = (blockNum + 1) != blockCount; // 다음 블럭이 있는지?
		this.nextBlock = startPage + BLOCK_SIZE;  // 다음 블록의 첫 페이지 번호
		this.prevBlock = startPage - BLOCK_SIZE;  // 이전 블록의 첫 페이지 번호
	}
}
