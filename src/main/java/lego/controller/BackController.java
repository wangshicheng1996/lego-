package lego.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lego.pojo.Product;
import lego.pojo.Sales;
import lego.pojo.User;
import lego.service.ProductService;
import lego.service.SalesService;
import lego.service.UserService;

//后台管理
@Controller
public class BackController {
	
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	@Autowired
	SalesService salesService;
	
	
	
	//后台管理首页
	@RequestMapping("/back")
	public String manage(){
		return "/back/index";	
	}
	
	//商品管理,只查前25
	@RequestMapping("/back/product")
	public String product(Model model,int m,int n){
		//查询所有商品信息
		List<Product> productList = productService.findAllProduct25(m,n);
		
		model.addAttribute("productList", productList);
		model.addAttribute("m", m);
		model.addAttribute("n", n);
		
		return "/back/product";	
	}
	
	//用户管理
	@RequestMapping("/back/user")
	public String user(Model model,int m,int n){
		//查询所有用户信息
		List<User> userList = userService.findAllUser20(m,n);
		
		model.addAttribute("userList", userList);
		model.addAttribute("m", m);
		model.addAttribute("n", n);
		return "/back/user";	
	}
	
	//权限管理
	@RequestMapping("/back/permissions")
	public String permissions(Model model){
		//查询所有用户信息
		List<User> userList = userService.findAllUser20(0,20);	
		model.addAttribute("userList", userList);
		
		return "/back/permissions";	
	}
	
	//销售管理
	@RequestMapping("/back/sale")
	public String sale(Model model){
		//查询所有商品销售表
		List<Sales> salesList = salesService.findAllSales();
		model.addAttribute("salesList", salesList);
		return "/back/sale";	
	}
	
	
	
	
	
	
	
	
	//重定向到商城首页
	@RequestMapping("/back/index")
	public String index(){
		return "redirect:/index.jsp";	
	}
	
	//商品管理中删除根据id商品
	@RequestMapping("/BackProdDelete")
	public String BackProdDelete(String productId){
		
		//根据id删除商品
		productService.deleteById(productId);
		
		return "redirect:/back/product?m=0&n=20";	
	}
	
	//商品管理中根据id商品修改商品数量
	@RequestMapping("/BackAjaxChangeCount")
	public void BackAjaxChangeCount(String productId,Integer count,HttpServletResponse response) throws IOException{
		
		//根据id修改商品
		boolean flag = productService.changeCount(productId,count);
		response.getWriter().write(""+flag);
			
	}
	
	//添加商品数量--------------待实现
//		@RequestMapping("/backAddProd")
//		public String backAddProd(Product product,MultipartFile imgurl,HttpServletRequest req) throws IOException{
//			String path=req.getSession().getServletContext().getRealPath("");
//			
//		      	String productImgurl="image"+ImagePath.getImagePath()+UUID.randomUUID().toString()+".jpg";
//			
//			if(imgurl!=null && imgurl.getSize()>0){
//				FileUtils.writeByteArrayToFile(new File(path+productImgurl), imgurl.getBytes());
//			}
//				
//			product.setProductImgurl(productImgurl.replaceAll("\\\\", "/"));
//			
//			productService.saveProd(product);
//			
//			return "redirect:/toManageProdList.action";
//		}
	

	//用户管理中删除根据id
	@RequestMapping("/BackUserDelete")
	public String BackUserDelete(String userId){
		
		//根据id删除用户
		userService.deleteById(userId);
		
		return "redirect:/back/user?m=0&n=20";	
	}
	
	//用户管理---设为普通用户
	@RequestMapping("/BackUpdateUser")
	public String BackUpdateUser(String userId){
		
		//将用户设为普通用户
		userService.updateUser(userId,"3");
		
		
		return "redirect:/back/permissions";	
	}
	
	//用户管理---设为管理员
	@RequestMapping("/BackUpdateAdmin")
	public String BackUpdateAdmin(String userId){
		
		//将用户设为管理员
		userService.updateUser(userId,"2");
		
		return "redirect:/back/permissions";	
	}
	
	
	//跳转图表
	@RequestMapping("/SalesPicture")
	public String SalesPicture(Model model){
				
		List<Sales> salesList = salesService.findAllSales();
		model.addAttribute("salesList", salesList);
		
		return "/echarts/柱状图";	
	}

	
	

}
