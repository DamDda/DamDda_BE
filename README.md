# DamDda_BE

# data initialization

1. 기존에 있던 테이블 삭제

2. application.properties 에서 ddl-auto=create 설정
  ```
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
spring.jpa.defer-datasource-initialization=true

spring.sql.init.mode=always
spring.sql.init.data-locations=classpath:data/members.sql,\
  classpath:data/categories.sql,\
  classpath:data/tags.sql,\
  classpath:data/projects.sql,\
  classpath:data/project_tag.sql,\
  classpath:data/approval.sql,\
  classpath:data/project_image_type.sql,\
  classpath:data/project_images.sql,\
  classpath:data/project_documents.sql
```

3. 데이터 잘 들어갔는지 확인 후 ddl-auto=update 로 설정 후 주석 처리
  ```spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
spring.jpa.defer-datasource-initialization=true

#spring.sql.init.mode=always
#spring.sql.init.data-locations=classpath:data/members.sql,\
#  classpath:data/categories.sql,\
#  classpath:data/tags.sql,\
#  classpath:data/projects.sql,\
#  classpath:data/project_tag.sql,\
#  classpath:data/approval.sql,\
#  classpath:data/project_image_type.sql,\
#  classpath:data/project_images.sql,\
#  classpath:data/project_documents.sql```
   
