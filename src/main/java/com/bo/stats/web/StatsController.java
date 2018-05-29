package com.bo.stats.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bo.baseball.vo.BaseballVO;
import com.bo.stats.service.StatsService;
import com.bo.stats.vo.StatsVO;

@Controller
public class StatsController {

   ////////////////////////////////////////////////////////////////////////
   private StatsService statsService;
   private	List<StatsVO> statsList = new ArrayList<StatsVO>();
   
   public void setStatsService(StatsService statsService) {
	this.statsService = statsService;
   }
   /////////////////////////////////////////////////////////////////////////
   @RequestMapping("/") 
   public ModelAndView viewListPage(StatsVO statsVO) {
	  ModelAndView view = new ModelAndView();
	  getPharsing(statsVO);
	  view.setViewName("baseball/list");
	 
	  List<StatsVO> statsList = statsService.getAll(statsVO);
	  
	  view.addObject("statsList",statsList);
	  
	  return view;
   }
   @RequestMapping("/getStats")
   public String getPharsing(StatsVO statsVO) {
	   String target = "http://sports.news.naver.com/kbaseball/record/index.nhn?category=kbo";
	   	
         try {
            //doc 에 내가 원하는 페이지의 모든 내용이 담겨져있음
           Document doc = Jsoup.connect(target).get();
           Elements txt = doc.select("tbody#regularTeamRecordList_table tr");
            storeStatsData(txt);
            
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
            return "redirect:/";
   		}
            
   private void storeStatsData(Elements ele) {
	   
      StatsVO statsVO;
      statsService.removeStats();
      
      for (Element node : ele) {
        	 
        	statsVO = new StatsVO();

        	
        	Elements th = node.select("th");
            Elements td = node.select("td");
            
            if( Integer.parseInt(th.text()) < 10) {
            	String ex = "0"+ th.text();
            	statsVO.setRank(ex);
            }
            else {
            	statsVO.setRank(th.text());
            }
            statsVO.setTeam(td.get(0).select("div>span").text());
            statsVO.setRound(td.get(1).select("td>span").text());
            statsVO.setWin(td.get(2).select("span").text());
            statsVO.setLose(td.get(3).select("span").text());
            statsVO.setDraw(td.get(4).select("span").text());
            statsVO.setWinAvg(td.get(5).select("strong").text());
            statsVO.setGamesBehind(td.get(6).select("span").text());
            statsVO.setStraight(td.get(7).select("span").text());
            statsVO.setOnBase(td.get(8).select("span").text());
            statsVO.setLongHit(td.get(9).select("span").text());
            statsVO.setRecentTenRound(td.get(10).select("span").text());
           
            statsService.createStats(statsVO);
            
         }
   }
   
}