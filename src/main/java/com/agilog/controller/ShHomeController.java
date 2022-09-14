package com.agilog.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.agilog.beans.AuthBean;
import com.agilog.beans.BebeCalendarBean;
import com.agilog.beans.BoardBean;
import com.agilog.beans.CompanyBean;
import com.agilog.beans.DailyDiaryBean;
import com.agilog.beans.HealthDiaryBean;
import com.agilog.beans.MyPageBean;
import com.agilog.beans.PostBean;
import com.agilog.beans.ReservationBean;
import com.agilog.services.Authentication;
import com.agilog.services.BebeCalendar;
import com.agilog.services.BebeMap;
import com.agilog.services.Board;
import com.agilog.services.Company;
import com.agilog.services.DailyDiary;
import com.agilog.services.DashBoard;
import com.agilog.services.MyPage;
import com.agilog.services2.HealthDiary2;
import com.agilog.services3.Board3;

@Controller
public class ShHomeController {
	@Autowired
	Authentication auth;
	@Autowired
	DashBoard dashBoard;
	@Autowired
	Company company;
	@Autowired
	DailyDiary dailyDiary;
	@Autowired
	BebeMap bebeMap;
	@Autowired
	BebeCalendar bebeCalendar;
	@Autowired
	Board board;
	@Autowired
	MyPage myPage;
	@Autowired
	HealthDiary2 healthDiary;
	@Autowired
	Board3 board3;

	// 기업 회원가입 페이지 이동
	@RequestMapping(value = "/MoveCompanyJoinPage", method = RequestMethod.GET)
	public ModelAndView moveCompanyJoinPage(ModelAndView mav, @ModelAttribute AuthBean auth) {
		this.auth.backController(mav, 13);

		return mav;
	}
	
	// 기업 회원가입 완료
	@RequestMapping(value = "/CompanyJoin", method = RequestMethod.POST)
	public ModelAndView companyJoin(ModelAndView mav, @ModelAttribute CompanyBean cb) {
		mav.addObject("companyBean", cb);
		this.auth.backController(mav, 21);

		return mav;
	}
	
	// 건강일기 추세 페이지 이동
	@RequestMapping(value = "/MoveHealthStatusPage", method = RequestMethod.POST)
	public ModelAndView moveHealthStatusPage(ModelAndView mav, @ModelAttribute HealthDiaryBean hdb) {
		mav.addObject("healthDiaryBean", hdb);
		this.healthDiary.backController(mav, 21);
		
		return mav;
	}
	
	// 게시판 글보기 이동
	@RequestMapping(value = "ShowFreePostCtl", method = RequestMethod.POST)
	public ModelAndView showFreePostCtl(ModelAndView mav, @ModelAttribute PostBean pb) {
		mav.addObject("postBean", pb);
		this.board3.backController(mav, 580);
		
		return mav;
	}
	
	// 지도 예약완료
	@RequestMapping(value = "/Reservation", method = RequestMethod.POST)
	public ModelAndView reservation(ModelAndView mav, @ModelAttribute ReservationBean rb){
		mav.addObject("reservationBean", rb);
		this.bebeMap.backController(mav, 44);
		
		return mav;
	}
	
}
