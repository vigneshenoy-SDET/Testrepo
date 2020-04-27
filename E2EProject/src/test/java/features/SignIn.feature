Feature: Amazon sign-in steps

  Scenario Outline: Validate steps to create new Amazon accounts
    Given Launch url "https://www.amazon.com"
      And Navigate to SignIn page
     When User enters name <uname>,email <email> and password <pword> 
     Then New account should be created
     And Close the browser
    Examples: 
      | uname              | email              | pword       | 
      | Wayne Rooney       | wrooney10@mutd.com | w_rooney10! | 
      | Christiano Ronaldo | cr_7@mutd.com      | cr_pword@7  | 
