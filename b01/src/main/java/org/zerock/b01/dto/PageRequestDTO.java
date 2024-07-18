package org.zerock.b01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Builder
@Data
@AllArgsConstructor //모든 필드를 인자로 받는 생성자를 자동으로 생성
@NoArgsConstructor //인자가 없는 기본 생성자를 자동으로 생성
public class PageRequestDTO { // 클라이언트가 요청 시 전달한 페이징 및 검색 조건을 담고 있음
    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    private String type; //검색종류 t,c,w,tc,tw,twc
    private String keyword;

    private String link;

    public String[] getTypes() {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return type.split(""); //예를들어 type이 "tc"인 경우, 이 메서드는 ["t", "c"]를 반환
    }

    public Pageable getPageable(String...props) { //
        return PageRequest.of(this.page - 1, this.size, Sort.by(props).descending());
        //예를 들어, page가 2이고, size가 10이며, props가 "bno" 인 경우,
        //이 메서드는 2번째 페이지(0부터 시작), 페이지당 10개의 항목, bno 를 기준으로
        //내림차순 정렬된 PageRequest 객체를 반환
    }

    public String getLink(){
        if(link==null){ //link가 이미 생성된 적이 있는지를 판단하고 link가 null인 경우, 새로운 URL 쿼리 문자열을 생성
            StringBuilder builder = new StringBuilder();
            builder.append("page="+this.page);
            builder.append("&size="+this.size);

            if(type != null && type.length()>0){
                builder.append("&type="+type);
            }
            if(keyword != null){
                try{
                    builder.append("&keyword=" + URLEncoder.encode(keyword,"UTF-8"));
                }catch(UnsupportedEncodingException e){
                }
            }
            link = builder.toString();
        }
        return link;
    }
}
