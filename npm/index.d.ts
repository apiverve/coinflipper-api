declare module '@apiverve/coinflipper' {
  export interface coinflipperOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface coinflipperResponse {
    status: string;
    error: string | null;
    data: CoinFlipperData;
    code?: number;
  }


  interface CoinFlipperData {
      totalFlips:      number;
      flips:           FirstFlip[];
      headsCount:      number;
      tailsCount:      number;
      headsPercentage: number;
      tailsPercentage: number;
      longestStreak:   LongestStreak;
      firstFlip:       FirstFlip;
      lastFlip:        FirstFlip;
      isFair:          boolean;
  }
  
  enum FirstFlip {
      Heads = "Heads",
      Tails = "Tails",
  }
  
  interface LongestStreak {
      length: number;
      type:   FirstFlip;
  }

  export default class coinflipperWrapper {
    constructor(options: coinflipperOptions);

    execute(callback: (error: any, data: coinflipperResponse | null) => void): Promise<coinflipperResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: coinflipperResponse | null) => void): Promise<coinflipperResponse>;
    execute(query?: Record<string, any>): Promise<coinflipperResponse>;
  }
}
