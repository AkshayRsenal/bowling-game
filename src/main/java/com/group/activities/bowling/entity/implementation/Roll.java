package com.group.activities.bowling.entity.implementation;

import java.time.LocalDateTime;

import com.group.activities.bowling.entity.IRoll;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "rolls")
public class Roll implements IRoll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pins_dropped_out", nullable = false)
    private int pinsDroppedOut;

    @Column(name = "roll_number", nullable = false)
    private int rollNumber;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(targetEntity = Frame.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "frame_id", nullable = false)
    private Frame frame;

    // Todo:Chnage rollNumber to Enum
    public Roll(int pinsDroppedOut, int rollNumber, Frame frame) {
        this.pinsDroppedOut = pinsDroppedOut;
        this.rollNumber = rollNumber;
        this.createdAt = LocalDateTime.now();
        this.frame = frame;
        validateRoll();
    }

    /**
     * Static factory method to create Roll from DTO
     */
    public static Roll createFromDto(int pinsDroppedOut, int rollNumber, Frame frame) {
        return new Roll(pinsDroppedOut, rollNumber, frame);
    }

    public LocalDateTime getTimestamp() {
        return createdAt;
    }

    public Boolean validateRoll() {
        if (this.pinsDroppedOut < 0 || this.pinsDroppedOut > 10) {
            throw new IllegalArgumentException("Pins dropped out must be between 0 and 10");
        }

        if (this.rollNumber < 1 || this.rollNumber > 3) {
            throw new IllegalArgumentException("Roll number must be between 1 and 3");
        }

        if (this.frame.getRolls().size() >= 3) {
            throw new IllegalArgumentException("A frame can only have a maximum of 3 rolls");
        }

        return true;
    }
}
