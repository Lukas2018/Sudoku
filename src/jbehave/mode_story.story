Scenario: Wybor trybu ze znakami rzymskimi 
Given mode
When ustaw mode na Roman
Then mode as Roman

Scenario: Wybor trybu ze znakami heksadecymalnymi
Given mode
When ustaw mode na Hex
Then mode as Hex