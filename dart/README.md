# Coin Flipper API - Dart/Flutter Client

Coin Flipper is a tool for simulating coin flips. It can flip multiple coins at once and provides statistics including heads/tails counts, percentages, streaks, and fairness analysis for probability experiments and gaming.

[![pub package](https://img.shields.io/pub/v/apiverve_coinflipper.svg)](https://pub.dev/packages/apiverve_coinflipper)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Coin Flipper API](https://apiverve.com/marketplace/coinflipper?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_coinflipper: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_coinflipper/apiverve_coinflipper.dart';

void main() async {
  final client = CoinflipperClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'flips': 1
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "total_flips": 10,
    "flips": [
      "Tails",
      "Tails",
      "Tails",
      "Tails",
      "Tails",
      "Heads",
      "Heads",
      "Heads",
      "Tails",
      "Tails"
    ],
    "heads_count": 3,
    "tails_count": 7,
    "heads_percentage": 30,
    "tails_percentage": 70,
    "longest_streak": {
      "length": 5,
      "type": "Tails"
    },
    "first_flip": "Tails",
    "last_flip": "Tails",
    "is_fair": false
  }
}
```

## API Reference

- **API Home:** [Coin Flipper API](https://apiverve.com/marketplace/coinflipper?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/coinflipper](https://docs.apiverve.com/ref/coinflipper?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
