package com.jsr303.test;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import com.ibm.bean.test.GroupB;
//定义验证的顺序
@GroupSequence(value={Default.class, GroupA.class, GroupB.class})
public interface Group {

}
