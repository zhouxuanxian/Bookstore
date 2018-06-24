package cn.abc.bookstore.tools;
import java.util.List;



public class Page<T> {
	private Integer count;
	private Integer totalPage;
	private Integer pageSize;
	private Integer currentPage;
	private List<T> lists = null;
	public Page() {
		super();
	}
	public Page(Integer count,Integer pageSize, Integer currentPage, List<T> lists) {
		super();
		this.count = count;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.lists = lists;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getTotalPage() {
		if(count%pageSize==0) {
			totalPage = count/pageSize;
		}
		else {
			totalPage = count/pageSize +1;
		}
		return totalPage;
	}
	
	//第一页
	public Integer getTopPageNo()
	{
		return 1;
	}
	
	//上一页
	public Integer getPreviousPageNo()
	{
		if(currentPage <= 1)
		{
			return 1;
		}
		else
		{
			return currentPage-1;
		}
	}
	
	//下一页
	public Integer getNextPageNo()
	{
		if (currentPage >= this.getTotalPage()) {
			return this.getBottomPageNo();
		}
		return currentPage+1;
	}
	
	
	//最后一页
	public Integer getBottomPageNo()
	{
		return getTotalPage() == 0?1:this.getTotalPage();
	}
	
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currenPage) {
		this.currentPage = currenPage;
	}
	public List<T> getLists() {
		return lists;
	}
	public void setLists(List<T> lists) {
		this.lists = lists;
	}
	

}
