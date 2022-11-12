# FOR RUN APPLICATION PUT:
    запуск из idea
    1 Edit configuration
    2 VM options -Dspring.profiles.active=local-chrome

    run chrome driver
    mvn clean verify -Dspring.profiles.active=local-chrome 
    
    run firefox driver
    mvn clean verify -Dspring.profiles.active=local-firefox

