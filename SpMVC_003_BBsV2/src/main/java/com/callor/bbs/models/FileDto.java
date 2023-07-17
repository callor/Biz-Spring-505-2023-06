package com.callor.bbs.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDto {
	private long i_seq;//	bigint
	private long i_bseq;//	bigint
	private String i_originalName;//	VARCHAR(125)
	private String i_uploadName;//	VARCHAR(255)

}
