package com.ibm.bean.test;

import javax.validation.groups.Default;
import javax.validation.GroupSequence;

@GroupSequence({Default.class, GroupA.class, GroupB.class})
public interface Group {

}
