declare module '@apiverve/coinflipper' {
  export interface coinflipperOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface coinflipperResponse {
    status: string;
    error: string | null;
    data: CoinFlipperData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface CoinFlipperData {
      totalFlips:      number | null;
      flips:           (FirstFlip | null)[];
      headsCount:      number | null;
      tailsCount:      number | null;
      headsPercentage: number | null;
      tailsPercentage: number | null;
      longestStreak:   LongestStreak;
      firstFlip:       FirstFlip | null;
      lastFlip:        FirstFlip | null;
      isFair:          boolean | null;
  }
  
  enum FirstFlip {
      Heads = "Heads",
      Tails = "Tails",
  }
  
  interface LongestStreak {
      length: number | null;
      type:   FirstFlip | null;
  }

  export default class coinflipperWrapper {
    constructor(options: coinflipperOptions);

    execute(callback: (error: any, data: coinflipperResponse | null) => void): Promise<coinflipperResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: coinflipperResponse | null) => void): Promise<coinflipperResponse>;
    execute(query?: Record<string, any>): Promise<coinflipperResponse>;
  }
}
