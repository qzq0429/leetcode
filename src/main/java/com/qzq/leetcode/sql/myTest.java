package com.qzq.leetcode.sql;

import com.qzq.leetcode.annotation.Column;
import com.qzq.leetcode.annotation.Id;
import com.qzq.leetcode.annotation.Table;

@Table(value = "test.unionindex")
public class myTest {
	
	@Id(type = "Integer",value = "a")
	private int A;
	@Column(type = "Integer",value = "b")
	private int B;
	@Column(type = "Integer",value = "c")
	private int C;
	@Column(type = "Integer",value = "d")
	private int D;
	@Column(type = "Integer",value = "e")
	private int E;
	
}
