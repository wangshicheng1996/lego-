package lego.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lego.utils.PaymentUtil;
import lego.utils.PropUtils;

@Controller
public class PayController {
	@RequestMapping("/pay")
	public String toPay(){
		
		return "/pay";
	}
	
	
	

	@RequestMapping("/paymentAction_pay")
	public String pay(HttpServletRequest request,HttpServletResponse response){
		//1.准备请求需要的请求参数
		String p0_Cmd="Buy";//业务型
		
		String  p1_MerId=PropUtils.getProperty("p1_MerId");//商户编号
		
		String p2_Order=request.getParameter("orderid");//订单号
		
		String p3_Amt="0.01";//支付金额，测试时使用0.01
		/*支付金额，正式使用时订单金额要根据订单的ID从数据库查询
		 * OrderService orderService=BasicFactory.
				getFactory().getInstance(OrderService.class);
		Order order=orderService.findOrderById(p2_Order);*/
		
		String p4_Cur="CNY";//交易币种
		String p5_Pid="";//商品名称
		String  p6_Pcat="";//商品种类
		String  p7_Pdesc="";//商品描述
		
		//回调的servlet：商户接收支付成功数据的地址
		String p8_Url=PropUtils.getProperty("responseURL");
		
		String p9_SAF="";//送货地址
		String  pa_MP="";//商户的扩展信息
		String  pd_FrpId=request.getParameter("pd_FrpId");//支付通道编码
		
		String pr_NeedResponse="1";// 应答机制
		//使用提供的工具和密钥对以上参数进行加密
		String hmac=PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, 
				p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, 
				p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, PropUtils.
				getProperty("keyValue"));
		//2.将以上参数保存到request作用域中
		request.setAttribute("pd_FrpId", pd_FrpId);
		request.setAttribute("p0_Cmd", p0_Cmd);
		request.setAttribute("p1_MerId", p1_MerId);
		request.setAttribute("p2_Order", p2_Order);
		request.setAttribute("p3_Amt", p3_Amt);
		request.setAttribute("p4_Cur", p4_Cur);
		request.setAttribute("p5_Pid", p5_Pid);
		request.setAttribute("p6_Pcat", p6_Pcat);
		request.setAttribute("p7_Pdesc", p7_Pdesc);
		request.setAttribute("p8_Url", p8_Url);
		request.setAttribute("p9_SAF", p9_SAF);
		request.setAttribute("pa_MP", pa_MP);
		request.setAttribute("pr_NeedResponse", pr_NeedResponse);
		request.setAttribute("hmac", hmac);
		return "/confirm";
	}
	
}
