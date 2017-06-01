--2017.05.30
/*    
    NN ==>Not Null
    PK ==> Primary Key
    FK ==> Foreign Key
    UK ==>Unique
    CK ==>Check

    명세서
    테이블명(emp)
    ==========================================
    컬럼명          sabun    name    job     hiredate    sal 
    ==========================================
    PK/FK/UK        PK    NN    CK        NN
    ==========================================
    참조테이블
    ==========================================
    참조컬럼
    ==========================================
    데이터형        number    varchar2    varchar2    date    number
    ==========================================
    크기        13    34    30        7,3
    ==========================================
*/
/*
create table mvcBoard(
    no number,
    name varchar2(34) constraint mb_no_nn not null,
    subject varchar2(1000)  constraint mb_sub_nn not null,
    content clob constraint mb_cont_nn not null,
    pwd varchar2(10) constraint mb_pwd_nn not null,
    regdate date default sysdate,
    hit number default 0,
    group_id number,
    group_step number default 0,
    group_tab number default 0,
    root number default 0,
    depth number default 0,
    constraint mb_no_pk primary key(no)
);
*/
--제약조건마다 이름을 줘야 바꾸는게 쉽다.
/*
        no     group_id        group_step     group_tab     root(상위답글no)     depth(하위 답글갯수)
AAAA        1    1        0        0        0         2
 -> BBBB        2    1        1        1        1         1    
  -> CCCC    3    1        2        2        2         0
 -> KKKK        5    1        3        1        1         0
DDDD        4    2        1        0        0         0




*/
/*
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(1, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 1);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(2, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 2);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(3, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 3);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(4, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 4);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(5, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 5);

commit;
*/
/*
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(6, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 6);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(7, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 7);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(8, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 8);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(9, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 9);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(10, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 10);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(11, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 11);
*/
/*
insert into mvcBoard(no, name, subject, content, pwd, group_id, group_step, group_tab)
values(12, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 11, 1, 1 );
insert into mvcBoard(no, name, subject, content, pwd, group_id, group_step, group_tab)
values(13, '홍길동', 'mvc를 이용한 답변형 게시판', '스프링(jstl, el)', '1234', 11, 2, 2);
commit; 
*/


