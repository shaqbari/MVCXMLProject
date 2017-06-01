--2017.05.30
/*    
    NN ==>Not Null
    PK ==> Primary Key
    FK ==> Foreign Key
    UK ==>Unique
    CK ==>Check

    ����
    ���̺��(emp)
    ==========================================
    �÷���          sabun    name    job     hiredate    sal 
    ==========================================
    PK/FK/UK        PK    NN    CK        NN
    ==========================================
    �������̺�
    ==========================================
    �����÷�
    ==========================================
    ��������        number    varchar2    varchar2    date    number
    ==========================================
    ũ��        13    34    30        7,3
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
--�������Ǹ��� �̸��� ��� �ٲٴ°� ����.
/*
        no     group_id        group_step     group_tab     root(�������no)     depth(���� ��۰���)
AAAA        1    1        0        0        0         2
 -> BBBB        2    1        1        1        1         1    
  -> CCCC    3    1        2        2        2         0
 -> KKKK        5    1        3        1        1         0
DDDD        4    2        1        0        0         0




*/
/*
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(1, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 1);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(2, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 2);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(3, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 3);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(4, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 4);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(5, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 5);

commit;
*/
/*
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(6, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 6);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(7, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 7);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(8, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 8);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(9, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 9);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(10, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 10);
insert into mvcBoard(no, name, subject, content, pwd, group_id)
values(11, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 11);
*/
/*
insert into mvcBoard(no, name, subject, content, pwd, group_id, group_step, group_tab)
values(12, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 11, 1, 1 );
insert into mvcBoard(no, name, subject, content, pwd, group_id, group_step, group_tab)
values(13, 'ȫ�浿', 'mvc�� �̿��� �亯�� �Խ���', '������(jstl, el)', '1234', 11, 2, 2);
commit; 
*/


