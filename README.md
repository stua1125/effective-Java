# today-i-learned
#TIL과 일일 커밋

### 2020.04.20(월)
마리이디비 db
BigDecimal type컬럼의 소수점은 truncate를 사용하여야한다.

### 2020.04.21(화)
how to js file import

// tag import
<script src="/view/js/HR/hr.getCodeData.js"></script>

// js script import
self.$content.append('<script src=\'/view/js/HR/hr.getCodeData.js\'><\/script>');


2020.04.22

Arrays.asList 와 array는 다르다. 
https://m.blog.naver.com/PostView.nhn?blogId=roropoly1&logNo=221140156345&proxyReferer=https:%2F%2Fwww.google.com%2F

문제발생 예 )
<if test="P_DEPT_CD != null and P_DEPT_CD.isEmpty() == false">
 AND		( O.DEPT_CD IN
 <trim suffixOverrides = " OR O.DEPT_CD IN ()">            
<foreach collection="P_DEPT_CD" index="index" item="item" open="(" close=")">
    <if test = "index != 0">
	<choose>
	    <when test = "index % 1000 == 999">) OR O.DEPT_CD IN (</when>
	    <otherwise>,</otherwise>
	</choose>
    </if>
    #{item}
</foreach>            </trim>

<if test="P_DEPT_CD != null and P_DEPT_CD.isEmpty() == false">

나오는 결과값 
Arrays.asList("".split("\\|")).size()  // 1

Arrays.asList("".split("\\|")).isEmpty() // false
