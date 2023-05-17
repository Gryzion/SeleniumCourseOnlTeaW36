Feature: Mystore - order and payment
  Scenario: User places and pays for the order
    Given User is logged in to Mystore "https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account"
    When User choose "Hummingbird Printed Sweater"
    And Choose "M" size
    And Choose 5 pieces
    And Add to cart
    And Go to 'PROCEED TO CHECKOUT'
    And User selects a delivery address
    And Choose a Self pick up - 'pickup in store'
    And Choose - 'Pay by Check'
    And Click on - 'I agree to the terms of service and will adhere to them unconditionally'
    Then Take screenshot of the order confirmation and amount
