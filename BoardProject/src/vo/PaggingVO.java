package vo;
/*
 * 현재 사용자가 조회하고 있는 페이지 정보를 가지고 있음
 * 현재 페이지 번호, 
 * 전체 글 개수,
 * 한 페이지당 출력할 글 목록 개수,
 * 게시판 하단에 나타낼 페이지 번호 개수
 * 이 4가지를 사용해 클래스를 만들 것.
 */
public class PaggingVO {
	//전체 게시글 개수
	private int count;
	//한 페이지당 출력할 게시글(글 목록) 개수 -중간에 변하면 안되서 상수로 선언
	private final int pageOfContentCount = 7;
	//게시판 하단에 나타낼 페이지 번호 개수
	private final int pageGroupOfCount = 4;
	//현재 페이지 번호 - 이걸 알아야 시작 페이지 번호와 끝나는 페이지 번호 목록을 알수있음
	private int currentPage;
	
	public PaggingVO(int count, int currentPage) {
		super();
		this.count = count;
		this.currentPage = currentPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	//총 페이지 개수를 return하는 메소드
	//전체 게시글 개수 / 한 페이지에 보여줄 글번호 개수 --> 나머지가 0일때
	//전체 게시글 개수 / 한 페이지에 보여줄 글번호 개수 + 1 --> 나머지가 0이 아닐때
	public int getTotalPage() {
		int totalPage = count / pageOfContentCount;
			if(count % pageOfContentCount != 0) {
				totalPage++;
			}
		return count / pageOfContentCount;
	}
		/*
		 * 총 페이지 그룹 수 : 4 <br>
		 *페이지 번호 : 1,2,3,4,5,6,7,8,9,10,11,12,13 <br>
		 *그룹 1 : 1,2,3,4 <br>
		 *그룹 2 : 5,6,7,8 <br>
		 *그룹 3 : 9,10,11,12 <br>
		 *그룹 4 : 13 <br>
		*/
	//전체 총 페이지 그룹 개수 구하는 메소드
	public int getTotalPageGroup() {
		int result = getTotalPage() / pageGroupOfCount;
		if(getTotalPage()  % pageGroupOfCount != 0) {
			result++;
			}
		return result;
	}
	//현재 페이지의 그룹 번호
	public int getNowPageGroupNo() {
		int result =  currentPage / pageGroupOfCount;
		if(currentPage % pageGroupOfCount != 0) {
			result++;
		}
		return result;
	}
	//현재 페이지 그룹의 시작 페이지 번호
		/*
		 * 페이지 번호 1 2 3 4 5 6 7 8 9 10 11 12 13<br>
		 * 1그룹 : <b>1</b> 2 3 4<br>
		 * 2그룹 : <b>5</b> 6 7 8<br>
		 * 3그룹 : <b>9</b> 10 11 12<br>
		 * 4그룹 : <b>13</b><br>
		*/
	public int getStartPageOfPageGroup() {
		return pageGroupOfCount * (getNowPageGroupNo()-1)+1;
	}
	//현재 페이지 그룹의 마지막 페이지 번호
		/*
		 *  페이지 번호 1 2 3 4 5 6 7 8 9 10 11 12 13<br>
		 * 1그룹 : 1 2 3 <b>4</b><br>
		 * 2그룹 : 5 6 7 <b>8</b><br>
		 * 3그룹 : 9 10 11 <b>12</b><br>
		 * 4그룹 : <b>13</b><br>
		*/
	public int getEndPageOfPageGroup() {
		int result = pageGroupOfCount * getNowPageGroupNo();
		if(getTotalPage() < result) {
			result = getTotalPage(); //전체 페이지 개수는 마지막 페이지 번호로 봐도 됨
		}
		return result;
	}
	//이전 페이지 그룹이 있는지 체크
	// <<의 (이전 페이지 그룹으로 이동하기 위한) 출력 여부를 위한 메서드
	public boolean isPreviousPageGroup() {
		return getNowPageGroupNo() > 1;
	}
	
	//다음 페이지 그룹이 있는지 체크
	// >>의(다음 페이지 그룹으로 이동하기 위한) 출력 여부를 위한 메서드
	public boolean isNextPageGroup() {
		return getNowPageGroupNo() < getTotalPageGroup();
		//true 면 >>이 나오고 거짓이면 이동 버튼이 안나옴 
	}
	
}