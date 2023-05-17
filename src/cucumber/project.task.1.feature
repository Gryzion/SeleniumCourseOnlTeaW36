Feature: Creating a new address after logging in - Mystore
  Scenario Outline: Add successfully new address
    Given Logged in to MyStore "https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account"
    When Button Addresses clicked goes to "https://mystore-testlab.coderslab.pl/index.php?controller=addresses"
    And Button clicked "+Create new address"
    And Fill form New Address: "<alias>", "<address>", "<city>", "<zip/postal code>", "<country>", "<phone>"
    Then Check that the address details are correct

    Examples:
      | alias     | address        | city      | zip/postal code | country         | phone       |
      | przyklad  | Sienkiewicza 1 | Bialystok | 15-110          | United Kingdom  | 222-333-444 |

