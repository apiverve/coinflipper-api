/// Response models for the Coin Flipper API.

/// API Response wrapper.
class CoinflipperResponse {
  final String status;
  final dynamic error;
  final CoinflipperData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  CoinflipperResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory CoinflipperResponse.fromJson(Map<String, dynamic> json) => CoinflipperResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? CoinflipperData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Coin Flipper API.

class CoinflipperData {
  num? totalFlips;
  List<String>? flips;
  num? headsCount;
  num? tailsCount;
  num? headsPercentage;
  num? tailsPercentage;
  CoinflipperDataLongestStreak? longestStreak;
  String? firstFlip;
  String? lastFlip;
  bool? isFair;

  CoinflipperData({
    this.totalFlips,
    this.flips,
    this.headsCount,
    this.tailsCount,
    this.headsPercentage,
    this.tailsPercentage,
    this.longestStreak,
    this.firstFlip,
    this.lastFlip,
    this.isFair,
  });

  factory CoinflipperData.fromJson(Map<String, dynamic> json) => CoinflipperData(
      totalFlips: json['total_flips'],
      flips: (json['flips'] as List?)?.cast<String>(),
      headsCount: json['heads_count'],
      tailsCount: json['tails_count'],
      headsPercentage: json['heads_percentage'],
      tailsPercentage: json['tails_percentage'],
      longestStreak: json['longest_streak'] != null ? CoinflipperDataLongestStreak.fromJson(json['longest_streak']) : null,
      firstFlip: json['first_flip'],
      lastFlip: json['last_flip'],
      isFair: json['is_fair'],
    );
}

class CoinflipperDataLongestStreak {
  num? length;
  String? type;

  CoinflipperDataLongestStreak({
    this.length,
    this.type,
  });

  factory CoinflipperDataLongestStreak.fromJson(Map<String, dynamic> json) => CoinflipperDataLongestStreak(
      length: json['length'],
      type: json['type'],
    );
}

class CoinflipperRequest {
  int? flips;

  CoinflipperRequest({
    this.flips,
  });

  Map<String, dynamic> toJson() => {
      if (flips != null) 'flips': flips,
    };
}
