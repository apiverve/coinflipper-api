# Coin Flipper API - PHP Package

Coin Flipper simulates random coin flips and records heads or tails outcomes with flip counts. Paid plans can simulate multiple flips per request and calculate percentages, streak lengths, and fairness indicators.

## Installation

Install via Composer:

```bash
composer require apiverve/coinflipper
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Coinflipper\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['flips' => 1]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Coinflipper\Client;
use APIVerve\Coinflipper\Exceptions\APIException;
use APIVerve\Coinflipper\Exceptions\ValidationException;

try {
    $response = $client->execute(['flips' => 1]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "total_flips": 10,
    "flips": [
      "Tails",
      "Heads",
      "Heads",
      "Tails",
      "Tails",
      "Heads",
      "Tails",
      "Tails",
      "Tails",
      "Tails"
    ],
    "heads_count": 3,
    "tails_count": 7,
    "heads_percentage": 30,
    "tails_percentage": 70,
    "longest_streak": {
      "length": 4,
      "type": "Tails"
    },
    "first_flip": "Tails",
    "last_flip": "Tails",
    "is_fair": false
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/coinflipper?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/coinflipper?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/coinflipper?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
