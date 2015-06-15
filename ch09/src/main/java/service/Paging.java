package service;

public class Paging {
	private int currentPage=1; //현재단
	private int rowPage = 10;
	private int pageBlock = 10;
	private int strat; 
	private int end; 
	private int startPage;  //블록당 시작하는 번호
	private int endPage;  //블록당 끝나는번호
	private int total;
	private int totalPage;
	public Paging(int total, String currentPage1) {
							 //int값이면 null로 물어보지못하기때문에 문자로 잡음
		this.total =total;
		if(currentPage1 != null){
			this.currentPage = Integer.parseInt(currentPage1);
		}
		strat = (currentPage -1)*rowPage +1;
		end = strat + rowPage -1;
			//내용 번호
		totalPage = (int)Math.ceil((double)total / rowPage); 
						//double형으로 나눠야 int가 double이 됨
		startPage = currentPage -(currentPage -1) % pageBlock;
		endPage = startPage + pageBlock -1;
			//아래 페이지번호
		if(endPage > totalPage){
			endPage = totalPage;
		}
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRowPage() {
		return rowPage;
	}
	public void setRowPage(int rowPage) {
		this.rowPage = rowPage;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStrat() {
		return strat;
	}
	public void setStrat(int strat) {
		this.strat = strat;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
