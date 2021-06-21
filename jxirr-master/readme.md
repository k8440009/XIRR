1. main
value, dates

2. XIRR
GoalSeekData
GoalSeekStatus
result
rate
n
d_n

goal_seek_initialize
xmin
xmax
rate

status <- goalSeekNewton
status -> 괜찮으면 -> double
status -> 안 좋으면 -> 0

3. GoalSeek
goal_seek_initialize
goalSeekNewton

4. GoalSeekData
xmin, xmax, precision
havepos, xpos, ypos
havexneg, xneg, yneg
have_root, root

5. GoalSeekStatus
GOAL_SEEK_OK, GOAL_SEEK_ERROR

6. 