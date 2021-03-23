package com.example.demo.service;

import com.example.demo.samsung.domain.RcsMessageDomain;

public interface RcsSendMessageService {
	public void rcsSendMsgToMaap(RcsMessageDomain rcsMessageDomain) throws Exception;
}
