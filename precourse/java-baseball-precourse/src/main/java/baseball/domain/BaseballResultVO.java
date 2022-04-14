package baseball.domain;

import baseball.common.Constants;

import java.util.Objects;

public class BaseballResultVO {
    private final int strike;
    private final int ball;

    public BaseballResultVO(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isFinish() {
        return strike == Constants.BASEBALL_NUMBER_SIZE;
    }

    public boolean isBoth() {
        return (strike > 0 && ball > 0);
    }

    public boolean isNoting() {
        return (strike == 0 && ball == 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballResultVO resultVO = (BaseballResultVO) o;
        return getStrike() == resultVO.getStrike() && getBall() == resultVO.getBall();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStrike(), getBall());
    }

    @Override
    public String toString() {
        return "BaseballResultVO{" +
                "strike=" + strike +
                ", ball=" + ball +
                '}';
    }
}